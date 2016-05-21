
# do the lines from p1->p2 and p3->p4 intersect?
def intersecting(p1, p2, p3, p4):
	x1, y1 = p1
	x2, y2 = p2
	x3, y3 = p3
	x4, y4 = p4

	l1 = line_equation(p1, p2)
	l2 = line_equation(p3, p4)

	print l1(x3), y3

	return (l1(x3) - y3) * (l1(x4) - y4) <= 0 or (l2(x1) - y1) * (l2(x2) - y2) <= 0

def line_equation(p1, p2):
	x1, y1 = p1
	x2, y2 = p2
	return lambda x: ((y2 - y1)/(x2 - x1)) * (x - x1)

print intersecting((1, 1), (2, 2), (1, 2), (3, 0))