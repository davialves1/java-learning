import React, {useEffect, useState} from 'react';
import axios from "axios";
import Card from "../Card/Card";

const AllEmployeesList = () => {

      useEffect(() => {
        setIsLoading(true);
        async function fetch () {
          return axios.get('http://localhost:8080/get-all');
        }
        fetch().then(async (employees) => setTimeout(() => handleEmployees(employees.data), 2000));
      }, [])

      const [employees, setEmployees] = useState([]);

      const [isLoading, setIsLoading] = useState(false);

      const employeesCards = employees.map((employee, index) => {
        return (
            <div className="col-md-6 col-12 p-3" key={`${employee}-${index}`}>
              <Card employee={employee}/>
            </div>
        );
      });

      const employeesCardList =
          <div className="container-fluid mb-5">
            <div className="row">
              {employeesCards}
            </div>
          </div>

      const loading = isLoading ? <img className="img-fluid p-5 m-5 w-25"
                                       alt="loading-spinner"
                                       src="https://c.tenor.com/I6kN-6X7nhAAAAAj/loading-buffering.gif"/>
          : <></>;

      const employeesList = employees.length > 0 && !isLoading ? employeesCardList
          : <></>;

      const handleEmployees = (employees) => {
        employees.sort((a, b) => b.id - a.id);
        setEmployees(employees);
        setIsLoading(false);
      }

      return (
          <>
            <div className="text-center">
              <p>{loading}</p>
            </div>
            {employeesList}
          </>
      )
    }
;

export default AllEmployeesList;
