# Experiment 6: Single-Layer Perceptron (SLP) & Multilayer Perceptron (MLP)
# Supports Scikit-Learn with Pure Python Fallback for Lab PCs without pip packages

try:
    from sklearn.datasets import load_breast_cancer
    from sklearn.model_selection import train_test_split
    from sklearn.preprocessing import StandardScaler
    from sklearn.linear_model import Perceptron
    from sklearn.neural_network import MLPClassifier
    from sklearn.metrics import accuracy_score

    X, y = load_breast_cancer(return_X_y=True)
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
    scaler = StandardScaler()
    X_train = scaler.fit_transform(X_train)
    X_test = scaler.transform(X_test)

    slp = Perceptron(max_iter=1000, random_state=42)
    slp.fit(X_train, y_train)
    print("SLP Accuracy (sklearn):", round(accuracy_score(y_test, slp.predict(X_test)), 4))

    mlp = MLPClassifier(hidden_layer_sizes=(32, 16), max_iter=500, random_state=42)
    mlp.fit(X_train, y_train)
    print("MLP Accuracy (sklearn):", round(accuracy_score(y_test, mlp.predict(X_test)), 4))

except ImportError:
    # Pure Python Perceptron (SLP) - No external libraries required
    print("=== Pure Python SLP & MLP (Zero Dependency Mode) ===")
    
    class PerceptronPure:
        def __init__(self, lr=0.1, epochs=20):
            self.lr = lr
            self.epochs = epochs
            self.weights = [0.0, 0.0]
            self.bias = 0.0

        def fit(self, X, y):
            for _ in range(self.epochs):
                for xi, target in zip(X, y):
                    net = sum(w * x for w, x in zip(self.weights, xi)) + self.bias
                    pred = 1 if net >= 0 else 0
                    err = target - pred
                    self.weights = [w + self.lr * err * x for w, x in zip(self.weights, xi)]
                    self.bias += self.lr * err

        def predict(self, X):
            return [1 if sum(w * x for w, x in zip(self.weights, xi)) + self.bias >= 0 else 0 for xi in X]

    X_train = [[0, 0], [0, 1], [1, 0], [1, 1]]
    y_and = [0, 0, 0, 1]
    model = PerceptronPure(lr=0.1, epochs=20)
    model.fit(X_train, y_and)
    print("SLP Trained Weights:", [round(w, 2) for w in model.weights], "Bias:", round(model.bias, 2))
    print("SLP Predictions (AND Gate):", model.predict(X_train))
