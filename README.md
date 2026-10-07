# AISC Practical & Viva Exam Kit (5th Semester)

> **Artificial Intelligence & Soft Computing Practical & Oral Examination Preparation Suite**  
> **Prepared for:** Aaryan Choube (24CE1045) • Batch A / A1

---

## ⚡ 1-Click Access Links (Zero-Login TinyURLs)
- 📱 **DAA-Style Ultra-Compact Pocket Print (2-Page PDF):** [**`tinyurl.com/aisc-pocket`**](https://tinyurl.com/aisc-pocket) *(Exact Consolas 4.5pt, 3-column format as DAA pocket print, includes Viva)*
- 🌐 **Live Web Portal (1-Click Copy Buttons):** [**`tinyurl.com/aisc-exam`**](https://tinyurl.com/aisc-exam) *(Alt: `tinyurl.com/aisc-portal`)*
- 📦 **Download Entire Kit as ZIP:** [**`tinyurl.com/aisc-zip`**](https://tinyurl.com/aisc-zip)
- 📄 **Readable Macro Sheet (7.0 pt, 3-Page PDF):** [**`tinyurl.com/aisc-macro`**](https://tinyurl.com/aisc-macro) *(Large, comfortable font, 2 columns)*
- 🌟 **Master Viva & Oral Exam Guide (25 Q&A):** [**`tinyurl.com/aisc-viva`**](https://tinyurl.com/aisc-viva)

---

## 📂 Experiments & Code Index

| Exp # | Experiment Title | Languages | Core Implementation Files |
|:---:|:---|:---:|:---|
| **01** | AI Agents & PEAS Description | Theory & Specs | [PEAS_Task_Environments.txt](./Exp%2001%20-%20PEAS%20Description%20(AI%20Agents)/PEAS_Task_Environments.txt) |
| **02** | Water Jug Problem (State Space Search) | Java & Python | [WaterJugSolver.java](./Exp%2002%20-%20Water%20Jug%20Problem%20(BFS%20Graph%20Search)/WaterJugSolver.java), [water_jug.py](./Exp%2002%20-%20Water%20Jug%20Problem%20(BFS%20Graph%20Search)/water_jug.py) |
| **03** | Tic-Tac-Toe Game Playing (Minimax) | Java | [TicTacToeMinimax.java](./Exp%2003%20-%20Tic-Tac-Toe%20Game%20Playing%20(Minimax%20%26%20Alpha-Beta)/TicTacToeMinimax.java) |
| **05** | Informed Heuristic Search (A* Search) | Java | [AStarSearch.java](./Exp%2005%20-%20Informed%20Heuristic%20Search%20(A-Star%20Algorithm)/AStarSearch.java) |
| **06** | Logic Programming in PROLOG | PROLOG (`.pl`) | [family_and_weather.pl](./Exp%2006%20-%20Logic%20Programming%20(PROLOG%20Rules)/family_and_weather.pl) |
| **07** | Fuzzy Logic & Fuzzy Sets | Java | [FuzzyOperations.java](./Exp%2007%20-%20Fuzzy%20Logic%20%26%20Fuzzy%20Sets%20(Union%2C%20Intersection%2C%20Complement)/FuzzyOperations.java) |
| **10** | Neural Networks (Single-Layer Perceptron) | Java | [Perceptron.java](./Exp%2010%20-%20Neural%20Networks%20(Single-Layer%20Perceptron)/Perceptron.java) |

---

## 🚀 Quick Execution Guide on College Lab PCs

### 1. Java Compilation & Execution:
```bash
javac ClassName.java
java ClassName
```

### 2. Python Execution (Exp 2):
```bash
python water_jug.py
```

### 3. PROLOG Execution (Exp 6 in SWI-Prolog):
```bash
swipl family_and_weather.pl
?- warmer_than(phoenix, la).
?- grandparent(joe, X).
```

---

## 🎯 High-Yield Viva Formulae & Definitions
- **Water Jug Solvability:** Solvable if and only if $d \le \max(J_1, J_2)$ and $d \pmod{\gcd(J_1, J_2)} == 0$. BFS guarantees minimum pours.
- **Minimax & Alpha-Beta:** Two-player zero-sum game tree. Prunes subtree when $\beta \le \alpha$. Time complexity drops to $O(b^{m/2})$.
- **A* Evaluation Function:** $f(n) = g(n) + h(n)$. Heuristic is **admissible** if $h(n) \le h^*(n)$ (never overestimates). Admissibility guarantees optimal path!
- **Consistent Heuristic:** $h(n) \le c(n, a, n') + h(n')$. Consistency implies admissibility.
- **Perceptron Learning Rule:** $w_i \leftarrow w_i + \eta (y_{\text{target}} - y_{\text{actual}}) x_i$. Fails on XOR because XOR is non-linearly separable!
- **Fuzzy Operations:** Union = $\max(\mu_A, \mu_B)$, Intersection = $\min(\mu_A, \mu_B)$, Complement = $1 - \mu_A$.
- **Defuzzification (Centroid):** $z^* = \frac{\sum z \cdot \mu(z)}{\sum \mu(z)}$.
