
class LinkedList(object):

	class Link(object):
		def __init__(self, data, next=None):
			self.data = data
			self.next = next

	def __init__(self, *elems):
		self.head = None
		self.tail = None
		if elems:
			self.head = self.Link(elems[-1])
			self.tail = self.head
			elems = elems[:-1]
		while elems:
			self.head = self.Link(elems[-1], self.head)
			elems = elems[:-1]

	def __str__(self):
		res = ''
		ptr = self.head
		while ptr:
			res += '({})->'.format(ptr.data)
			ptr = ptr.next
		return res[:-2]

	def insert(self, data):
		if not self.head:
			self.head = self.Link(data)
			self.tail = self.head
		else:
			self.tail.next = self.Link(data)
			self.tail = self.tail.next

	def remove(self, data):
		if self.head and self.head.data == data:
			self.head = self.head.next
			if not self.head:
				self.tail = self.head
			return True
		elif self.head:
			ptr = self.head
			while ptr.next:
				if ptr.next.data == data:
					if ptr.next is self.tail:
						self.tail = ptr
					ptr.next = ptr.next.next
					return True
				else:
					ptr = ptr.next
		return False

	def remove_all(self, data):
		while self.remove(data):
			pass

	def contains(self, data):
		ptr = self.head
		while ptr:
			if ptr.data == data:
				return True
		return False

	def reverse(self):
		ptr = self.head
		res = LinkedList()
		while ptr:
			res.head = self.Link(ptr.data, res.head)
			ptr = ptr.next

		return res

	def is_empty(self):
		return self.head == None

	def remove_first(self):
		if self.is_empty():
			return None
		res = self.head.data
		if self.head == self.tail:
			self.tail = None
		self.head = self.head.next

		return res


class Stack(object):

	def __init__(self):
		self.l = LinkedList()

	def peek(self):
		if self.l.is_empty():
			return None
		return self.l.head.data

	def push(self, data):
		self.l.head = LinkedList.Link(data, self.l.head)
		if self.l.tail == None:
			self.l.tail = self.l.head

	def pop(self):
		return self.l.remove_first()

	def __str__(self):
		return str(self.l)


if __name__ == '__main__':
	s = Stack()
	s.push(1)
	s.push(2)
	s.push(3)
	print s
	print s.pop()
	print s.pop()
