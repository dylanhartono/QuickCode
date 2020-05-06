# Week 5: Exam!
_Lead: Dylan Hartono_

This week we will be practicing thinking in binary. Keep that in mind when working on the problem this week. I think this one will be a little tough, but I wouldn't be surprised if you guys get this one pretty quickly.

## Problem Statement

_Adapted from 2020 ICPC Coding Competition Question 1!_

At Zoom University, students have found out that after taking a quiz they can see what the right answers should be along with their score. Therefore, many have been cheating by looking at the answer key after their friend has taken the quiz. After realizing that the average of quizzes being significantly higher than previous years, professors realized students are not as morally upright as they are and have cheated on quizzes.

**Shame on them!**

In an attempt to prevent students from cheating, professors created a system where answers are hidden until the end, but still being a bit nice, professors gave scores to students right away. This was right before the exam, so students were starting to get nervous. The professor said not to worry though; the entire exam would be true or false.

Being a genius, you have your friend take the exam first and record his or her answers. Then you take your exam and record the answers that you put. Taking the answers and score your friend got, you want to see the maximum amount of points you can get on the exam. 

**How are you going to do that?**

### Tests

input | friend's score | your answers | friend's answers | output |
|---|---|---|---|---|
1|2| "TTTT"      |"TTTT"        |2| 
2|3| "FTFFF"     |"TFTTT"       |2| 
3|6| "TTFTFFTFTF"| "TTTTFFTTTT" |9|


#### BTW PS!
ICPC is a coding competition for college students to take in the fall. UW takes a part in this, and hopefully next year, we can send a team over to get some nice rep for QuickCode club :)

## Helpful information
```
s.charAt()                  // you can get a character at a specific index
s.equals()                  // compares strings
s.substring(start, end)     // returns a substring from s (start inclusive, end exclusive)
```

The solution has a lot of variables! Yes there is probably a quick way to do it, but try to solve the problem intuitively and quickly!