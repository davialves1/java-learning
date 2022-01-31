import React, {useState} from 'react';
import axios from "axios";
import Card from "./Card";

const EmployeesList = () => {

  const [employees, setEmployees] = useState([]);

  const [isLoading, setIsLoading] = useState(false);

  const employeesCards = employees.map((employee, index) => {
    return (
        <div className="col-md-6 col-12 p-2" key={`${employee}-${index}`}>
          <Card employee={employee}/>
        </div>
    );
  });

  const employeesCardList =
      <div className="container-fluid mt-5">
        <div className="row">
          {employeesCards}
        </div>
      </div>

  const loading = isLoading ? <img className="img-fluid p-5 m-5"
                                   src="https://c.tenor.com/I6kN-6X7nhAAAAAj/loading-buffering.gif"/>
      : <></>;

  const employeesList = employees.length > 0 && !isLoading ? employeesCardList : <></>;

  const fetchEmployees = async () => {
    setIsLoading(true);
    await axios.get('http://localhost:8080/get-all').then(async (employees) => {
        setTimeout(() => {
          employees.data.sort((a, b) => b.id - a.id)
          setEmployees(employees.data);
          setIsLoading(false);
        }, 2000);

    });
}
return (
    <>
      <div className="text-center">
        <button className="btn btn-outline-primary px-5 py-3"
                onClick={fetchEmployees}>
          Fetch Employees
        </button>
        <p>{loading}</p>
      </div>
      {employeesList}
    </>
)
}
;

export default EmployeesList;
