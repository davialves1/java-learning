import React from "react";
import './Card.scss';

const Card = (props) => {

  const fullName = `${props.employee.firstName} ${props.employee.lastName}`;

  const backgroundImage = 'https://www.linkedin-makeover.com/wp-content/uploads/2021/02/Background-21-1024x256-1.png'

  return (
      <>
        <div className="card">
          <img src={backgroundImage} className="card-img-top" alt="..." />
          <div className="card-body">
            <div id="avatar"
                 className="avatar rounded-circle mb-3 text-center text-white py-3 display-6 bg-primary">
              <strong>
                {props.employee.firstName[0]}
                {props.employee.lastName[0]}
              </strong>
            </div>
            <h5 className="card-title">{fullName}</h5>
            <p className="pt-2">{props.employee.email}</p>
            <p className="card-text">
              Some quick example text to build on the
              card title and make up the bulk of the card's content.
            </p>
            <a href="#" className="btn btn-outline-primary py-3 px-5 my-3"
            >See profile</a>
          </div>
        </div>
      </>
  )
};

export default Card;
