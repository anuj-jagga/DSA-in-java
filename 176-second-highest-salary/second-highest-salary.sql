SELECT MAX(salary) AS SecondHighestSalary
FROM Employee
WHERE salary < (
    Select MAX(salary) FROM Employee
)
