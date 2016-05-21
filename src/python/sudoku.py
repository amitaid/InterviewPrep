
class Board(object):

	def __init__(self, *filled_cells):
		self.cells = [[0 for i in xrange(9)] for j in xrange(9)]
		for (i, j, n) in filled_cells:
			self.cells[i][j] = n

	def __str__(self):
		res = '   1 2 3 | 4 5 6 | 7 8 9'
		for i in xrange(9):
			if i % 3 == 0:
				res += '\n -----------------------'
			res += '\n{}| {}'.format(str(i+1), self.format_row(i))
		return res
		
	def format_row(self, row):
		r = map(str, self.cells[row])
		return ' | '.join(map(' '.join, [r[0:3], r[3:6], r[6:9]]))

	def get_row(self, row):
		return self.cells[row]

	def get_column(self, col):
		return [row[col] for row in self.cells]

	def get_square(self, i):
		sqi = i / 3
		sqj = i % 3
		return [self.cells[i / 3 + sqi * 3][i % 3 + sqj * 3] for i in xrange(9)]

def verify_9(nine):
	s = set()
	for x in nine:
		if x != 0 and x in s:
			return False
		else:
			s.add(x)
	return True

def verify_board(board):
	for i in xrange(9):
		if not (verify_9(board.get_row(i)) and verify_9(board.get_column(i)) and verify_9(board.get_square(i))):
		 	return False
	return True


if __name__ == '__main__':
	b = Board((1, 1, 3), (1, 2, 3))

	print verify_board(b)
