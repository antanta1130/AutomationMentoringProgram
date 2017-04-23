Home task 1
Deadline - 22.02.2017
Page 18 of the presentation (use GIT or e-mail to show your code to the mentor)

Solving Quadratic equation
𝑎𝑥^2+𝑏𝑥+𝑐=0
𝑥_1,2=(−𝑏±√(𝑏^2−4𝑎𝑐))/2𝑎
Declare three double variables a,b and c
Initialize them while declaring
Declare two double variables x1 and x2
Assign them with solved roots
Note: please use Math.sqrt() for taking square root
Note: use System.out.println() for output


Home task 2
Deadline - 01.03.2017
Add checks to previous task (discriminant is less then zero, a is equal to zero, etc).



Home task 3
Deadline - 15.03.2017
Task - page 39
Optional (to get 5 mark) - page 40
https://kb.epam.com/display/GDOKB/Lecture+3.+Basis+Java%2C+part+2

1. By using the bubble sort algorithm, write a Java program to sort an integer array of 10 elements in ascending.
2. Find if number belongs to the array using binary search algorithm (Hint: use bubble sort from previous task)

Optional tasks
1. Write a program called CheckOddEven which prints "Odd Number" if the intvariable “number” is odd, or “Even Number” otherwise. 
2. Write a program called PrintNumberInWord which prints "ONE", "TWO",... , "NINE", "OTHER" if the int variable "number" is 1, 2,... , 9, or other, respectively. 
3. Write a program called SumAndAverage to produce the sum of 1, 2, 3, ..., to 100. Also compute and display the average. 
4. Write a program called ComputePI to compute the value of π (compare it with Math.PI)
5. Write a program called HarmonicSum to compute the sum of a harmonic series, as shown below, where n=50000


Home task 5
https://kb.epam.com/display/GDOKB/Lecture+5.+Basis+Java,+part+4

Suppose you have written a time server that periodically notifies its clients of the current date and time. 
Write an interface the server could use to enforce a particular protocol on its clients
Write some code to use this interface for different time servers implementation

NOTE!!! Time server call could be something like System.out.println(“server impl 1 called”)

Home task 7
Deadline - 20.04.2017
1. Реализовать алгоритм сжатия строки. Набор повторяемых букв должен быть заменен на цифру (указывает количество повторов) и букву которая повторяется. Например
Heeellooooo будет заменено на H3e2l5o
если количество букв в повторе больше девяти то тогда должно быть две комбинации буква цифра. Например
Heeeeeeeeeeeellooooo будет заменено на H9e3e2l5o
Если буква не повторяется то замену производить не нужно. Например
World будет преобразован в World так как тут повторений нет

2. Реализовать алгоритм разбора и вычисления строки в обратной польской записи https://en.wikipedia.org/wiki/Reverse_Polish_notation.
Например выражение 
5 1 2 + 4 × + 3 − 
будет вычислено в 14
В случае если выражение невозможно вычислить необходимо выбросить исключение RPNParserException. Класс исключения реализовать самостоятельно.
В случае если в выражении произойдет деление на ноль, например: 0 0 / или любое другое в ходе вычисления которого возникает ошибка деления на ноль необходимо выбросить ArithmeticException (https://docs.oracle.com/javase/7/docs/api/java/lang/ArithmeticException.html)

3. Реализовать декодер строки из первого задания. Например
H9e3e2l5o будет преобразовано в Heeeeeeeeeeeellooooo
При реализации необходимо проверять корректность строки на входе. Например: 9 или H9 при преобразовании должны вернуть пустую строку!
