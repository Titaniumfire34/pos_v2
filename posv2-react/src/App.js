import React from "react";
import Navbar from './Navbar';
import Kitchen from './Kitchen';
import api from './api/axiosConfig';
import {useState,useEffect} from 'react';
import Layout from "./components/Layout";
import {Routes, Route} from 'react-router-dom';
import Home from './components/home/Home';

function App() {

  const[floor,setTables] = useState();
  const[table,setTable] = useState();

  const getTables = async () =>{
    try{
      const response = await api.get("/api/v1/movies");
      console.log(response.data);
      setTables(response.data);

    } catch(err){
      console.log(err);
    }
  }

  const getTableData = async (tableID) => {
    try{
      const response = await api.get('/api/v1/tables/${tableID}');
      const singleTable = response.data;
      setTable(singleTable);

    }catch(error) {

    }
  }

  useEffect(() => {
    getTables();
  },[])

  return (
    <Routes>
      <div className="App">
        <Navbar />
        <div className="content">
          
           <Route path="/" element = {<Layout/>}>
            <Route path="/"element= {<Home/>}> 
            </Route>
            </Route>

            <Route path="/Kitchen">
              <Kitchen />
            </Route>

        </div>
      </div>
    </Routes>
  );
}

export default App
