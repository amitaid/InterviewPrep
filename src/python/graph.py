from linked import Stack


class Vertex(object):

	def __init__(self, name):
		self.neighbors = set()
		self.name = name

	def __str__(self):
		return self.name

	def connect(self, other):
		self.neighbors.add(other)

	def is_connected(self, other):
		return other in neighbors


class Graph(object):

	def __init__(self, *verts):
		self.verticles = set()

		for v in verts:
			self.verticles.add(v)



def find_path(graph, src, dest):
	
	if dest in src.neighbors:
		return [src, dest]

	unvisited = [src]
	path_track = {}

	while dest not in path_track and unvisited:
		current = unvisited[0]
		unvisited = unvisited[1:]

		for n in current.neighbors:
			path_track[n] = current
			unvisited.append(n)

	if dest not in path_track:
		return None
	else:
		path = [dest]
		prev = dest
		while prev != src:
			prev = path_track[prev]
			path = [prev] + path

		return path


def find_path_dfs(graph, src, dest):
	if src == dest:
		return [dest]
	else:
		for neighbor in src.neighbors:
			find = find_path_dfs(graph, neighbor, dest)
			if find == None:
				pass
			else:
				return [src] + find
	return None



v1 = Vertex('a')
v2 = Vertex('b')
v3 = Vertex('c')
v4 = Vertex('d')
v5 = Vertex('e')

v1.connect(v2)
v1.connect(v3)
v2.connect(v3)
v3.connect(v5)
v2.connect(v4)
v4.connect(v5)

g = Graph(v1, v2, v3, v4, v5)

for v in g.verticles:
	for vv in v.neighbors:
		print str(v) + ' -> ' + str(vv)

print map(str, find_path(g, v2, v5))
print map(str, find_path_dfs(g, v2, v5))
