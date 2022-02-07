import './App.css';
import AllEmployeesList from "./All-Employees-List/All-Employees-List";
import Home from "./Home/Home";
import Menu from "./Menu/Menu";
import env from "./env";
import {BrowserRouter, Route, Routes} from "react-router-dom";

function App() {
  return (
      <div>
        <BrowserRouter>
          <div className="container-fluid">
            <div className="row bg-light shadow sticky-top">
              <div className="col-10 col-md-8 mx-auto text-center py-4">
                <h2>
                  <a href={env.local} className="text-decoration-none ">
                    <span className="p-2 grey display-6">Employee Management</span>
                  </a>
                </h2>
              </div>
            </div>
            <div className="row">
              <div
                  className="col-3 bg-light vh-100 pt-5 px-4 d-none d-md-block">
                <Menu/>
              </div>
              <div className="col-12 col-md-9 pt-3 vh-100 overflow-scroll">
                <Routes>
                  <Route path="/" element={<Home/>}/>
                  <Route path="/all-employees" element={<AllEmployeesList/>}/>
                </Routes>
              </div>
            </div>
          </div>
        </BrowserRouter>
      </div>
  );
}

export default App;
