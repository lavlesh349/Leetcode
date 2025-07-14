CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
        Select if( Count(*)<N OR N<=0, null, Min(a.salary)) from (Select Distinct Salary from Employee order by salary desc limit N) a
  );
END