SELECT w1.id 
FROM Weather w1
JOIN Weather w2
ON DATEDIFF(w1.recordDate,w2.recordDate) = 1  -- Pick rows where w1 date is exactly 1 day after w2 date
WHERE w1.temperature > w2.temperature