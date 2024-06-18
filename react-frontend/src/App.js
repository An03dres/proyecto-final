import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import { Outlet } from "react-router-dom";

const App = () => {
  return (
      <div>
        <Header />
            <div id="detail">
                <Outlet />
            </div>
        <Footer />
      </div>
  );
};

export default App;
