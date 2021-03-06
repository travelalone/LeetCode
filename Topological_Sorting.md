# Topological Sorting

## Introduction

对于有向无环图(Directed Acyclic Graph)， 存在边uv, 遍历时， u节点在v节点前面， 按照这种方式遍历所有节点。

Topological Sorting has two different implementions.

## Kahn’s algorithm for Topological Sorting

Based on the fact that a DAG has at least one vertex with in-degree 0 and one vertex with out-degree 0 (A DAG must have a longest path which has no incoming edge and outgoing edge). So the algorithm for the Topological Sorting could be describe as follow:

1. Copmute In-degree for all of the vertex and initailize the count as 0
2. Pick all vertices with in-degree 0 and add them to a queue
3. remove a vetex from queue
    1. increase the count of visited node by 1
    2. decrease in-degree by 1 for all of the neighboring nodes
    3. if the neighboring nodes is reduced  to zero then and it to the queue
4. repeat step 3 until the queue is empty
5. If the count is not equals to the number of the vertex, then there is a cycle in the graph, we can't topolocial sort the graph.

## Topological Sorting using depth first search

Recall that when using depth first serach, we use the stack to keep the order of which has been encountered. Now the idea is the same:

1. Define a stack to save the vertex
2. for all of the vertexes
    1. start from a vertex i that has not been travesaled, call toplogical sorting for all of it's adjacent vertices
    2. push the vertex i to the stack
3. pop the vertex from the stack

## code

The code can be found in the [src/topologicalSort.java](https://github.com/travelalone/LeetCode/blob/master/src/topologicalSort.java)