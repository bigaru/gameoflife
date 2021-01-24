# Conway's Game of Life

## Rules
- If a cell has 0-1 neighbors, it dies due to solitude.
```
[*][ ][ ]       [ ][ ][ ]
[ ][*][ ]   ->  [ ][ ][ ]
[ ][ ][ ]       [ ][ ][ ]
```

- If a cell has 2-3 neighbors, it survives.
```
[*][ ][ ]       [ ][ ][ ]
[ ][*][ ]   ->  [*][*][ ]
[ ][*][ ]       [ ][ ][ ]
```

- If a cell has 4 or more neighbors, it dies due to overpopulation.    
```
[*][ ][*]       [*][ ][ ]
[*][*][ ]   ->  [*][ ][ ]
[ ][*][*]       [*][*][*]
```


- If 3 neighbors are populated, then empty cell becomes populated.
```
[*][ ][ ]       [ ][ ][ ]
[*][ ][ ]   ->  [*][*][ ]
[ ][*][ ]       [ ][ ][ ]
```