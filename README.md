Project Description
The Vector Clock Simulator is a Java-based console application
that demonstrates event ordering in distributed systems.

It uses the Vector Clock algorithm to identify causal
relationships and concurrent events among distributed processes.
Objectives
- Understand distributed event ordering.
- Implement the Vector Clock algorithm.
- Simulate message sending and receiving.
- Identify causal and concurrent events.
Technologies Used
- Programming Language: Java
- Platform: Visual Studio Code
- Application: Console-based
Algorithm
1. Initialize all vector clocks to zero.
2. Increment the process clock for internal events.
3. Increment and attach the clock when sending messages.
4. Merge clocks using maximum values when receiving messages.
5. Compare timestamps to identify causal and concurrent events.
How to Run
Compile:
javac VectorClock.java

Execute:
java VectorClock
Expected Output
The program displays vector timestamps for P1, P2 and P3
and identifies concurrent events.
Conclusion
This project demonstrates how Vector Clocks maintain
logical ordering of events in distributed systems.
</CodeBlock>

