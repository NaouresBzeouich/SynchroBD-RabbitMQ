create DATABASE product_sales; 
use product_sales ;
CREATE TABLE sales (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Date DATE,
    Region VARCHAR(255),
    Product VARCHAR(255),
    Qty INT,
    Cost DECIMAL(10, 2),
    Amount DECIMAL(10, 2),
    Tax DECIMAL(10, 2),
    Total DECIMAL(10, 2)
);
INSERT INTO sales (Date, Region, Product, Qty, Cost, Amount, Tax, Total)
VALUES
('2024-04-01', 'East', 'Paper', 73, 12.95, 945.35, 66.17, 1011.52),
('2024-04-01', 'West', 'Paper', 33, 12.95, 427.35, 29.91, 457.26),
('2024-04-02', 'East', 'Pens', 14, 2.19, 30.66, 2.15, 32.81),
('2024-04-02', 'West', 'Pens', 40, 2.19, 87.60, 6.13, 93.73),
('2024-04-03', 'East', 'Paper', 21, 12.95, 271.95, 19.04, 290.99),
('2024-04-03', 'West', 'Paper', 10, 12.95, 129.50, 9.07, 138.57);

select * from sales ; 