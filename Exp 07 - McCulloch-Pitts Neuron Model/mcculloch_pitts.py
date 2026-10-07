# Experiment 7: McCulloch-Pitts Neuron Model (Python)
def mcculloch_pitts(inputs, weights, threshold):
    net = sum(x * w for x, w in zip(inputs, weights))
    return 1 if net >= threshold else 0

print("=== McCulloch-Pitts Logic Gates ===")
# AND Gate (weights=[1, 1], threshold=2)
for x1, x2 in [(0,0), (0,1), (1,0), (1,1)]:
    print(f"AND({x1}, {x2}) =", mcculloch_pitts([x1, x2], [1, 1], 2))

# OR Gate (weights=[1, 1], threshold=1)
for x1, x2 in [(0,0), (0,1), (1,0), (1,1)]:
    print(f"OR({x1}, {x2})  =", mcculloch_pitts([x1, x2], [1, 1], 1))

# NOT Gate (weight=[-1], threshold=0)
for x in [0, 1]:
    print(f"NOT({x})     =", mcculloch_pitts([x], [-1], 0))
