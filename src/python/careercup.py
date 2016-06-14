
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

	def mark(grid, distances, xy, d):
		x, y = xy
		if 0 <= y < sy and 0 <= x < sx and grid[y][x] != 'W' and distances[y][x] > d:
			distances[y][x] = d
			mark(grid, distances, (x-1, y), d+1)
			mark(grid, distances, (x+1, y), d+1)
			mark(grid, distances, (x, y-1), d+1)
			mark(grid, distances, (x, y+1), d+1)

	guards = []

	for i in xrange(sy):
		for j in xrange(sx):
			if mus[i][j] == 'G':
				guards.append((j, i))

	for guard in guards:
		mark(mus, res, guard, 0)

	return res


def merge_distances(mus, dist):
	for i in xrange(len(mus)):
		for j in xrange(len(mus[0])):
			if mus[i][j] != 'O':
				dist[i][j] = mus[i][j]
	return dist


def divide_slices(pies, ppl):
	def validate_k(pies, ppl, k):
		if k == 0:
			return True
		feed = 0
		for slices in pies:
			feed += slices / k
		return feed >= ppl

	def b_search_k(pies, ppl, start):
		k = 1
		while validate_k(pies, ppl, start + k):
			k *= 2
		if validate_k(pies, ppl, start + k - 1):
			return start + k - 1
		else:
			return b_search_k(pies, ppl, k/2)

	return b_search_k(pies, ppl, 0)


def array_cycles(A):
	l = len(A)
	if l < 2:
		return False
	slow, fast = A[0], A[1]
	while fast != slow:
		if A[fast] >= l or A[A[fast]] >= l:
			return False
		slow = A[slow]
		fast = A[A[fast]]

	return True


def shuffle_neighbors(s):
	counts = {}
	for c in s:
		counts[c] = counts.get(c, 0) + 1
	l = len(s)
	
	for c in counts:
		if counts[c] > (l+1)/2:
			return False

	return True


def is_step(n):
	d = n % 10
	n = n / 10
	while n > 0 and abs(d-(n%10))==1:
		print abs(d - (n%10))
		d = n%10
		n = n/10
	return n==0


def combis(l):
	def print_arr(arr, idx):
		print ''.join(arr[i][idx[i]] for i in xrange(len(arr)))

	length = len(l)
	idx = [0] * length
	ptr = length - 1
	print_arr(l, idx)

	while ptr >= 0:
		if idx[ptr] >= len(l[ptr])-1:
			idx[ptr] = 0
			ptr -= 1
		else:
			idx[ptr] += 1
			ptr = length - 1
			print_arr(l, idx)


def kakuro(s, n, p):
	def kakuro_list(s, n, pl, res):
		if s == 0 and n == 0:
			return [res]
		if s < 0 or n <= 0 or not pl:
			return []
		return kakuro_list(s-pl[0], n-1, pl, res + [pl[0]]) + kakuro_list(s, n, pl[1:], res)

	return kakuro_list(s, n, range(1, p+1), [])


def add_arrays(a1, a2):
	if len(a1) < len(a2):
		s, l = a1, a2
	else:
		s, l = a2, a1
	ls, ll = len(s), len(l)
	res = [0] * ll
	carry, diff = 0, ll - ls

	for i in xrange(1, ls+1):
		res[ll-i] = s[ls-i] + l[ll-i] + carry
		carry, res[ll-i] = res[ll-i]/10, res[ll-i]%10

	for i in xrange(1, diff+1):
		res[diff-i] = l[diff-i] + carry
		carry, res[diff-i] = res[diff-i]/10, res[diff-i]%10

	if carry:
		res = [1] + res

	return res

def add_and_swap_mid(list1, list2):
	res = list1 + list2
	mid = len(list1)
	if res[mid-1] > res[mid]:
		res[mid-1], res[mid] = res[mid], res[mid-1]
	return res


def reform_arrays(a1, a2):
	res = [a1[0]]
	temp = [a1[1], a2[0]]
	a1, a2 = a1[2:], a2[1:]

	while len(temp) > 2:
		temp = sorted(temp)
		res = res[:-1] + [temp[2], temp[0], temp[1]]
		temp = list()
		if a1:
			temp.append(a1[0])
			a1 = a1[1:]
		if a2:
			temp.append(a2[0])
			a2 = a2[1:]
		temp.append(res[-1])

	if len(temp) == 2:
		return res[:-1] + sorted(temp, reverse=True)
	else:
		return res

def reform_arrays_tailrec(a1, a2):
	def helper(a1, a2, result):
		if len(a1) == 0 or len(a2) == 0:
			return result + a1 + a2
		return helper(a1[1:], a2[1:], result + [max(a1[0], a2[0]), min(a1[0], a2[0])])

	return helper(a1, a2, list())

def find_palindrome(s):
	l = len(s)
	mat = [[0 for n in xrange(l+1)] for i in xrange(l)]

	# Init dynamic stuff
	for i in xrange(l):
		mat[i][0] = 1
	for i in xrange(l):
		mat[i][1] = 1

	# Fill array
	for n in xrange(2, l+1):
		for i in xrange(l-n+1):
			if mat[i+1][n-2] and s[i] == s[i+n-1]:
				mat[i][n] = 1

	# Print filled elements
	for i in xrange(l):
		for n in xrange(2, l+1):
			if mat[i][n]:
				print s[i:i+n]


def compare_str(s1, s2):
	i = 0
	while i < min(len(s1), len(s2)) and s1[i] == s2[i]:
		i += 1

	return s1[i:] == s2[i:] or s1[i:] == s2[i+1:] or s1[i+1:] == s2[i:] or s1[i+1:] == s1[i+1:]


if __name__ == '__main__':
	# print compare_str("aaa", "aaba")
	# find_palindrome("aa")
	# find_palindrome("ababa")

	print reform_arrays([100, 10, 11], [90, 0, 50])
	# print '\n'.join(merge_strings('abc', 'def'))

	# m1 = ['OOOOGOOOO',
	# 	    'OGOWOOOOO']
	# m2 = ['OOOOOOOWOG',
 	#       'OOOOOOOWOO',
	#       'OOOOWOOWOO',
	#       'OOOOWOOWWW',
	#       'OOOOWOGOOO',
	#       'WWWOWOOOOO',
	#       'OOOOWOOOOO',
	#       'OOOOWOOOOO',
	#       'OOOOWOOOOO',
	#       'GOOOWOOOOO']
	# print '\n'.join(m2), '\n'
	# print '\n'.join(map(lambda l: ''.join(map(str, l)), merge_distances(m2, museum(m2))))

	# pies = [17, 80, 13, 10, 6, 14]
	# ppl = 6
	# print divide_slices(pies, ppl)

	# cycle = [1, 2, 3, 4, 1]
	# no_cycle = [1, 2, 4, 1, 6]

	# print array_cycles(cycle)
	# print array_cycles(no_cycle)

	# print add_arrays([1, 2, 3], [])
