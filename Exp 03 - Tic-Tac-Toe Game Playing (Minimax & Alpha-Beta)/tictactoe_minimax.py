# Experiment 3: Tic-Tac-Toe Minimax Algorithm (Python)
import math

def evaluate(board):
    lines = [[0,1,2],[3,4,5],[6,7,8],[0,3,6],[1,4,7],[2,5,8],[0,4,8],[2,4,6]]
    for a, b, c in lines:
        if board[a] == board[b] == board[c] and board[a] != ' ':
            return 10 if board[a] == 'X' else -10
    return 0

def minimax(board, depth, is_max):
    score = evaluate(board)
    if score != 0: return score
    if ' ' not in board: return 0

    if is_max:
        best = -math.inf
        for i in range(9):
            if board[i] == ' ':
                board[i] = 'X'
                best = max(best, minimax(board, depth + 1, False))
                board[i] = ' '
        return best
    else:
        best = math.inf
        for i in range(9):
            if board[i] == ' ':
                board[i] = 'O'
                best = min(best, minimax(board, depth + 1, True))
                board[i] = ' '
        return best

def find_best_move(board):
    best_val, best_move = -math.inf, -1
    for i in range(9):
        if board[i] == ' ':
            board[i] = 'X'
            val = minimax(board, 0, False)
            board[i] = ' '
            if val > best_val:
                best_val, best_move = val, i
    return best_move

# Sample board: X is about to make the winning move
board = ['X', 'O', 'X', 'O', 'O', ' ', ' ', ' ', 'X']
print("=== Tic-Tac-Toe Minimax Move Selection ===")
print("Best Move Index for X:", find_best_move(board))
