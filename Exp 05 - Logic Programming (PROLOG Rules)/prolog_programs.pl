% Experiment 5: PROLOG Logic Programs (SWI-Prolog)
% =================================================

% 1. Weather Logic
weather(phoenix, summer, hot).
weather(la, summer, warm).
weather(phoenix, winter, warm).

warmer_than(C1, C2) :-
    weather(C1, summer, hot),
    weather(C2, summer, warm).

% 2. Family Tree Relations
parent(joe, jane).
parent(harry, carl).
parent(meg, jane).
parent(jane, anne).
parent(carl, ralph).
parent(hazel, harry).

grandparent(X, Z) :-
    parent(X, Y),
    parent(Y, Z).

ancestor(X, Y) :- parent(X, Y).
ancestor(X, Y) :- parent(X, Z), ancestor(Z, Y).

% 3. Temperature Conversion & Freezing Check
centigrade_to_fahrenheit(C, F) :-
    F is (C * 9 / 5) + 32.

is_below_freezing(C) :-
    C < 0.
