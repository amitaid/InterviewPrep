
class Node(object):

	def __init__(self, data, left=None, right=None):
		self.data = data
		self.left = left
		self.right = right

	def in_order(self):
		res = ''
		if self.left:
			res += self.left.in_order()
		res += str(self.data) + ' '
		if self.right:
			res += self.right.in_order()
		return res

	def height(self):
		l, r = 0, 0

		if self.left:
			l = self.left.height()
		if self.right:
			r = self.right.height()
		return 1 + max(l, r)

class BSNode(Node):

	def insert(self, data):
		if data < self.data:
			if self.left:
				self.left.insert(data)
			else:
				self.left = BSNode(data)
		else:
			if self.right:
				self.right.insert(data)
			else:
				self.right = BSNode(data)

class Tree(object):

	def __init__(self, root=None):
		self.root = root

	def in_order(self):
		return self.root.in_order()

	def height(self):
		return self.root.height()

	def __str__(self):
		return self.in_order()

	def invert(self):
		def invert_node(node):
			if node:
				node.left, node.right = node.right, node.left
				invert_node(node.left)
				invert_node(node.right)

		invert_node(self.root)
		return self

	def is_bst(self):
		def is_bst_node(node):
			res = True
			if node.left:
				res &= node.left.data < node.data and is_bst_node(node.left)
			if node.right:
				res &= node.right.data >= node.data and is_bst_node(node.right)
			return res
		return is_bst_node(self.root)
			

class BSTree(Tree):

	root = None

	def __init__(self, *elems):
		for elem in elems:
			self.insert(elem)

	def insert(self, data):
		if not self.root:
			self.root = BSNode(data)
		else:
			self.root.insert(data)


def build_bst_from_array(arr):
	def helper(arr, start, end):
		print start, end
		if end-start <= 0:
			return None
		elif end-start == 1:
			return BSNode(arr[start])
		elif end-start == 2:
			return BSNode(arr[start + 1], BSNode(arr[start]), None)
		else:
			mid = (end + start)/2
			return BSNode(arr[mid], helper(arr, start, mid), helper(arr, mid+1, end))
	
	return helper(arr, 0, len(arr))

if __name__ == '__main__':

	t = Tree(Node(5, Node(3), Node(6)))
	print t.invert().invert()
	print t.is_bst()

	arr =  [1, 2, 3, 4, 5, 6, 7]
	print str(build_bst_from_array(arr).in_order())




