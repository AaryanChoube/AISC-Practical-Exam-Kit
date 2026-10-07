# Experiment 4: Informed A* Search Algorithm (Python)
class Graph:
    def __init__(self, adj, h_map):
        self.adj = adj
        self.h = h_map

    def a_star(self, start, stop):
        open_set = {start}
        closed_set = set()
        g = {start: 0}
        parents = {start: start}

        while open_set:
            n = min(open_set, key=lambda v: g[v] + self.h.get(v, float('inf')))
            if n == stop:
                path = []
                while parents[n] != n:
                    path.append(n)
                    n = parents[n]
                path.append(start)
                path.reverse()
                return path

            open_set.remove(n)
            closed_set.add(n)

            for m, weight in self.adj.get(n, []):
                if m in closed_set: continue
                if m not in open_set: open_set.add(m)
                tentative_g = g[n] + weight
                if tentative_g < g.get(m, float('inf')):
                    g[m] = tentative_g
                    parents[m] = n
        return None

adj = {'A': [('B', 1), ('C', 3)], 'B': [('D', 5)], 'C': [('D', 1)], 'D': [('G', 2)]}
h = {'A': 4, 'B': 2, 'C': 2, 'D': 1, 'G': 0}
g = Graph(adj, h)
print("=== A* Search Algorithm ===")
print("Optimal Path A -> G:", g.a_star('A', 'G'))
