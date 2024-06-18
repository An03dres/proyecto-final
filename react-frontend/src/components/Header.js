// create a header

import React from 'react';
import { Link } from 'react-router-dom';

export default function Header () {
    return (
       <>
            <nav class="navbar navbar-expand-lg bg-dark border-bottom border-body" data-bs-theme="dark">
            <div class="container-fluid">
              <a class="navbar-brand" href="/">Tattoo Studio</a>
              <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="navbar-collapse collapse" id="navbarColor01">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <Link class="nav-link" to="/about">About</Link>
                  </li>
                  <li class="nav-item">
                    <Link class="nav-link" to="/booking">Book an Appointment</Link>
                  </li>
                </ul>
                <ul class="navbar-nav">
                  <li class="nav-item">
                    <a class="nav-link active" href="./login.html">
                      <span class="me-2">Login</span>
                      <i class="fa-solid fa-user"></i>
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
          </>
    );
}