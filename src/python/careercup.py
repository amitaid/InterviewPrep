
def print_dups(s):
	counts = {}
	order = ''

	for c in s:
		if not c in counts:
			order += c
			counts[c] = 1
		else:
			counts[c] = counts[c] + 1

	res = ''
	for c in order:
		res += c + str(counts[c])

	return res


def check_fib(n):
	a, b = 1, 1

	while b < n:
		a, b = b, a + b

	return b == n


def merge_strings(s1, s2):
	def rec(a, b, i):
		if len(a) == 0 or i >= len(b):
			return [b + a]
		else:
			return rec(a[1:], b[:i] + a[0] + b[i:], i+1) + rec(a, b, i+1)
	return rec(s1, s2, 0)


def museum(mus):
	sx, sy = len(mus[0]), len(mus)
	res = [[9 for x in xrange(sx)] for y in xrange(sy)]

	def mark(map, distances, xy, d):
		x, y = xy
		if 0 <= y < sy and 0 <= x < sx and map[y][x] != 'W' and distances[y][x] > d:
			distances[y][x] = d
			mark(map, distances, (x-1, y), d+1)
			mark(map, distances, (x+1, y), d+1)
			mark(map, distances, (x, y-1), d+1)
			mark(map, distances, (x, y+1), d+1)

	guards = []

	for i in xrange(sy):
		for j in xrange(sx):
			if mus[i][j] == 'G':
				guards.append((j, i))

	for guard in guards:
		mark(mus, res, guard, 0)

	return res






if __name__ == '__main__':
	
	m = ['OOOOGOOOO',
		 'OGOWOOOOO']
	print '\n'.join(m)
	print '\n'.join(map(lambda l: ''.join(map(str, l)), museum(m)))