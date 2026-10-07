# Experiment 8: Fuzzy Set Operations & Relations (Python)
# Supports NumPy with Pure Python Fallback for vanilla lab PCs

try:
    import numpy as np
    A = np.array([0.2, 0.5, 0.8, 1.0])
    B = np.array([0.3, 0.7, 0.6, 0.4])

    print("=== Fuzzy Set Operations (NumPy) ===")
    print("Union (A U B)        =", np.maximum(A, B))
    print("Intersection (A ^ B) =", np.minimum(A, B))
    print("Complement of A (~A) =", 1 - A)
    print("Difference (A - B)   =", np.minimum(A, 1 - B))

    R = np.minimum.outer(A, B)
    print("\nCartesian Product R (A x B):\n", R)

    S = np.array([[0.8, 0.4], [0.6, 0.7], [0.5, 0.9], [0.3, 0.8]])
    T = np.zeros((R.shape[0], S.shape[1]))
    for i in range(R.shape[0]):
        for j in range(S.shape[1]):
            T[i, j] = max(min(R[i, k], S[k, j]) for k in range(R.shape[1]))

    print("\nMax-Min Composition (R o S):\n", T)

except ImportError:
    print("=== Fuzzy Set Operations (Pure Python Mode) ===")
    A = [0.2, 0.5, 0.8, 1.0]
    B = [0.3, 0.7, 0.6, 0.4]

    print("Union (A U B)        =", [max(a, b) for a, b in zip(A, B)])
    print("Intersection (A ^ B) =", [min(a, b) for a, b in zip(A, B)])
    print("Complement of A (~A) =", [round(1 - a, 2) for a in A])
    print("Difference (A - B)   =", [round(min(a, 1 - b), 2) for a, b in zip(A, B)])

    R = [[min(a, b) for b in B] for a in A]
    print("\nCartesian Product R (A x B):")
    for row in R: print(" ", row)

    S = [[0.8, 0.4], [0.6, 0.7], [0.5, 0.9], [0.3, 0.8]]
    T = [[max(min(R[i][k], S[k][j]) for k in range(len(B))) for j in range(len(S[0]))] for i in range(len(A))]
    print("\nMax-Min Composition (R o S):")
    for row in T: print(" ", row)
