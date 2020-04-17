# Week One: Nesting Depth Parantheses
_Today's Lead: Dylan Hartono_

Today we are going to look at building and reading strings! Here are some basic commands to remember for the problem:

```
String s = "Something";         # This is how you create a String
char c = s.charAt(0);           # This grabs the character at index 0
s += s;                         # you can add Strings together
```

## Prompt
_Modelled after a problem in the qualification round of Google Code Jam 2020, Nesting Depth. Remodeled in order to cater to all levels_

>Given a _string of digits_, insert a minimum number of opening and closing parantheses into it such that the resulting string is balanced and each digit d is inside exactly d pairs of matching parantheses.

**Let's break it down**
We are given a set of digits, numbers, and we want to surround each digit by paranthesis that matches the number of the digit.

Kind of like this: `input: 4` --> `output: ((((4))))`

We can do that with multiple digits too: `input: 34` --> `output: (((3)))((((4))))`
**BUT THIS IS WRONG**

What we want to do is use the least amount of parantheses for the problem:

`input: 34`

`output: (((3(4))))`

so that we use the least amount of parantheses as possible

**Examples**
input | output |
| --- | --- |
| `0000` | `0000` |
| `0010` | `00(1)0` |
| `0110` | `0(11)0` |
| `1234` | `(1(2(3(4))))` |

### Testing
**THERE ARE THREE LEVELS TO TESTING**

First Tests:
- The first test will only have one number. If there are more than one number, they will be seperated with 0s (since 0 will never will have parantheses around it)
- Therefore, you do not have to focus on nesting the digits

Second Tests:
- There will just be one's and zero's, but the one's can be right next to each other like `0110` to get `0(11)0`
- This will practice some of the nesting

Third Tests: 
- You need to solve the case with any type of String of numbers such as `1134`, `68473646`, etc.
- This forces you to use nesting to find your solution

There is also another secret solution that does not have to use nesting at all. It'll solve all the tests. It uses a string function not mentioned above. It'll be a fun exercise if you figure this one out! 
