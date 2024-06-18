import React from 'react';
import { Link } from 'react-router-dom';

const Home = () => {
  return (
    <div>
      <h1>Welcome to Our Tattoo Studio</h1>
      <p>We offer a variety of tattoo styles from experienced artists. Book your session today!</p>
      <Link >
        <button>Book Now</button>
      </Link>
    </div>
  );
};

export default Home;
