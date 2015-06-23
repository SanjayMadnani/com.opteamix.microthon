# com.opteamix.microthon
MICROTHON, the ultimate coding challenge, Organized by Opteamix <https://www.opteamix.com/>.

The Code for Puzzle:
There are three baskets, one contains only apples, one contains only oranges, and one contains both apples and oranges. The baskets have been incorrectly labeled such that no label identifies the actual contents of the basket it labels. Opening just one basket, and without looking in the basket, you take out one piece of fruit. By looking at the fruit, how can you immediately label all of the baskets correctly? 

Solution:
lets assume:
basket 1 is labelled Oranges (O)
basket 2 is labelled Apples (A)
basket 3 is labelled Apples and Oranges (A+O)
and that ALL THREE BASKETS ARE LABELLED INCORRECTLY"

Pick a fruit from basket 1,

1) if you pick an Orange:
- basket 1's real label can only be O or A+O
- basket 1's current label is O
- since ALL LABELS ARE INCORRECT then basket 1's real label can not be O
- basket 1's new label should then be A+O by elimination
- since ALL LABELS ARE INCORRECT
- basket 2's label is changed to O
- basket 3's label is changed to A
- SOLVED

2) if you pick an Apple:
- basket 1's real label can only be A or A+O
- basket 1's current label is O
- since ALL LABELS ARE INCORRECT then basket 1's real label can not be O
- this still leaves us with the choice between label A and label A+O - which would both be correct
- FAILURE

Solution: The trick is to actually pick a fruit from the A+O labeled basket

Pick a fruit from basket 3:

1) if you pick an Orange:
- basket 3's real label can only be O or A
- basket 3's current label is A+O
- since ALL LABELS ARE INCORRECT then basket 3's real label can not be A+O
- basket 3's new label should then be O by elimination
- since ALL LABELS ARE INCORRECT
- basket 1's label is changed to A
- basket 2's label is changed to A+O
- SOLVED

2) if you pick an Apple:
- basket 3's real label can only be O or A
- basket 3's current label is A+O
- since ALL LABELS ARE INCORRECT then basket 3's real label can not be A+O
- basket 3's new label should then be A by elimination (not O)
- since ALL LABELS ARE INCORRECT
- basket 1's label is changed to A+O
- basket 2's label is changed to O
- SOLVED


