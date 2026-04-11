SELECT a.name AS EMPLOYEE
FROM Employee a
LEFT JOIN Employee b
ON a.managerId = b.id
WHERE a.salary > b.salary