import './App.css';
import EmployeesList from "./Employees-List/Employees-List";

function App() {
  return (
    <div>
      <div className="container-fluid">
        <div className="row bg-light shadow sticky-top">
          <div className="col-10 col-md-8 mx-auto text-center py-4">
            <h2>Employee Management</h2>
          </div>
        </div>
        <div className="row">
          <div className="col-3 bg-light vh-100 pt-5 px-4 d-none d-md-block">
            <ul className="list-group">
              <li className="list-group-item active" aria-current="true">
                All employees
              </li>
              <li className="list-group-item">Edit employee</li>
              <li className="list-group-item">Create employee</li>
              <li className="list-group-item">Update employee</li>
              <li className="list-group-item">Delete employee</li>
            </ul>
          </div>
          <div className="col-12 col-md-9 pt-5">
            <EmployeesList />
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
