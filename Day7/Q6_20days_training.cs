using System;

namespace InheritanceDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            // Create an instance of the Manager class
            Manager manager = new Manager("John", "Doe", "Sales", 50000);

            // Display the details of the manager
            Console.WriteLine("Manager Details:");
            Console.WriteLine("Name: {0} {1}", manager.FirstName, manager.LastName);
            Console.WriteLine("Department: {0}", manager.Department);
            Console.WriteLine("Salary: {0:C}", manager.Salary);

            // Create an instance of the Employee class
            Employee employee = new Employee("Jane", "Doe", 35000);

            // Display the details of the employee
            Console.WriteLine("\nEmployee Details:");
            Console.WriteLine("Name: {0} {1}", employee.FirstName, employee.LastName);
            Console.WriteLine("Salary: {0:C}", employee.Salary);

            Console.ReadLine();
        }
    }

    // Base class for employees
    class Employee
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public decimal Salary { get; set; }

        public Employee(string firstName, string lastName, decimal salary)
        {
            FirstName = firstName;
            LastName = lastName;
            Salary = salary;
        }
    }

    // Derived class for managers that inherits from Employee
    class Manager : Employee
    {
        public string Department { get; set; }

        public Manager(string firstName, string lastName, string department, decimal salary)
            : base(firstName, lastName, salary)
        {
            Department = department;
        }
    }
}

