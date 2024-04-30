import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import App from './App.jsx';
import './index.css';
import Login from './components/LoginForm.jsx';
import Register from './components/RegisterForm.jsx';
import ProductList from './components/ProductList.jsx';

ReactDOM.createRoot(document.getElementById('root')).render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<App />} />
      <Route path='/login' element={<Login/>} />
      <Route path='/product' element={<ProductList/>} />
      <Route path='/register' element={<Register/>} />

    </Routes>
  </BrowserRouter>
);
