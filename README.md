# AISC Practical & Viva Exam Kit (5th Semester)

> **Artificial Intelligence & Soft Computing Practical & Oral Examination Preparation Suite**  
> **Prepared for:** Aaryan Choube (24CE1045) • Batch A / A1  
> **Official Lab Manual Spec:** All coding experiments in **Python**, except Exp 5 in **SWI-PROLOG**!

---

## ⚡ 1-Click Access Links (Zero-Login TinyURLs)
- 🌐 **Live Web Portal (1-Click Copy Buttons):** [**`tinyurl.com/aisc-exam`**](https://tinyurl.com/aisc-exam) *(Alt: `tinyurl.com/aisc-portal`)*
- 📱 **DAA-Style Ultra-Compact Pocket Print (1-Page PDF):** [**`tinyurl.com/aisc-pocket`**](https://tinyurl.com/aisc-pocket) *(Exact Consolas 4.5pt, 3-column format, includes Quick Viva)*
- 📄 **Readable Macro Sheet (7.0 pt, 1-Page PDF):** [**`tinyurl.com/aisc-macro`**](https://tinyurl.com/aisc-macro) *(Large, readable font, 2 columns)*
- 📦 **Download Entire Kit as ZIP:** [**`tinyurl.com/aisc-download`**](https://tinyurl.com/aisc-download) *(Alt: `tinyurl.com/aisc-zip`)*
- 🌟 **Master Viva & Oral Exam Guide (25 Q&A):** [**`tinyurl.com/aisc-viva`**](https://tinyurl.com/aisc-viva)

---

## 📂 Official Syllabus Experiments & Code Index

| Exp # | Experiment Title | Official Language | Core Implementation Files |
|:---:|:---|:---:|:---|
| **01** | AI Agents & PEAS Description | Theory & Specs | [PEAS_Task_Environments.txt](./Exp%2001%20-%20PEAS%20Description%20(AI%20Agents)/PEAS_Task_Environments.txt) |
| **02** | Water Jug Problem (State Space Search) | **Python** | [water_jug.py](./Exp%2002%20-%20Water%20Jug%20Problem%20(BFS%20Graph%20Search)/water_jug.py) *(Java alt included)* |
| **03** | Tic-Tac-Toe Game Playing (Minimax & Alpha-Beta) | **Python** | [tictactoe_minimax.py](./Exp%2003%20-%20Tic-Tac-Toe%20Game%20Playing%20(Minimax%20%26%20Alpha-Beta)/tictactoe_minimax.py) |
| **04** | Informed Search (A* Search Algorithm) | **Python** | [astar_search.py](./Exp%2004%20-%20Informed%20Search%20(A-Star%20Algorithm)/astar_search.py) *(Java alt included)* |
| **05** | Logic Programming (Rules & Facts) | **SWI-PROLOG** | [prolog_programs.pl](./Exp%2005%20-%20Logic%20Programming%20(PROLOG%20Rules)/prolog_programs.pl) |
| **06** | Neural Networks (SLP and MLP) | **Python** | [perceptron_slp_mlp.py](./Exp%2006%20-%20Neural%20Networks%20(SLP%20and%20MLP)/perceptron_slp_mlp.py) |
| **07** | McCulloch-Pitts Neuron Model | **Python** | [mcculloch_pitts.py](./Exp%2007%20-%20McCulloch-Pitts%20Neuron%20Model/mcculloch_pitts.py) |
| **08** | Fuzzy Sets and Relations | **Python** | [fuzzy_operations.py](./Exp%2008%20-%20Fuzzy%20Sets%20and%20Relations/fuzzy_operations.py) *(Java alt included)* |
| **09** | Text Preprocessing & Cleaning UDF for GenAI | **Python** | [text_cleaning_udf.py](./Exp%2009%20-%20Text%20Preprocessing%20and%20Cleaning%20UDF/text_cleaning_udf.py) |

---

## 🚀 Quick Execution Guide on College Lab PCs

### 1. Python Execution (Exp 2, 3, 4, 6, 7, 8, 9):
```bash
python water_jug.py
python tictactoe_minimax.py
python astar_search.py
python perceptron_slp_mlp.py
python mcculloch_pitts.py
python fuzzy_operations.py
python text_cleaning_udf.py
```
*(All Python scripts include pure-Python auto-fallbacks so they run even without `scikit-learn` or `numpy` installed!)*

### 2. SWI-Prolog Execution (Exp 5):
```bash
swipl prolog_programs.pl
?- warmer_than(phoenix, la).
?- grandparent(joe, jane).
?- centigrade_to_fahrenheit(100, F).
```

---

## 🎯 High-Yield Viva Formulae & Definitions
- **Water Jug Solvability:** Solvable iff $d \le \max(J_1, J_2)$ and $d \pmod{\gcd(J_1, J_2)} == 0$. BFS guarantees minimum pours.
- **Minimax & Alpha-Beta:** Zero-sum game tree. Alpha: MAX lower bound; Beta: MIN upper bound. Prune branch when $\beta \le \alpha$. Time complexity drops to $O(b^{m/2})$.
- **A* Evaluation Function:** $f(n) = g(n) + h(n)$. Heuristic is **admissible** if $h(n) \le h^*(n)$ (never overestimates). Admissibility guarantees optimal path!
- **Consistent Heuristic:** $h(n) \le c(n, a, n') + h(n')$. Consistency implies admissibility.
- **Perceptron Learning Rule:** $w_i \leftarrow w_i + \eta (y_{\text{target}} - y_{\text{actual}}) x_i$. Fails on XOR because XOR is non-linearly separable!
- **Fuzzy Operations:** Union = $\max(\mu_A, \mu_B)$, Intersection = $\min(\mu_A, \mu_B)$, Complement = $1 - \mu_A$.
- **Defuzzification (Centroid):** $z^* = \frac{\sum z \cdot \mu(z)}{\sum \mu(z)}$.
