import { useEffect,useRef } from "react";
import api from '../../api/axiosConfig';
import {useParams} from 'react-router-dom';
import {Container,Row,Col} from 'react-bootstrap';
import TableForm from '../TableForm';
import React from "react";

const Tables = ({getTableData,table,setTable}) => {
    const revText = useRef();
    let params = usePArams();
    const tableId = params.tableId;

    useEffect(()=>{
        getTableData(tableId);
    },[])

    const addTable = async (e) =>{
        e.preventDefault();
        const rev = revText.current;
        try{
            const Response = await api.post("/api/v1/tables",{tableNumber:tableId, numberOfSeats: rev.value});
            const updatedTables = [...tables,{tableNumber:tableId}];
            rev.value = 0;
            setTable(updatedTables);

        }catch(err){
            console.error(err);
        }
    
    }

    return(
        <div>
            <Container>
                <Row>
                    <Col>
                    <h3>Tables</h3>
                    </Col>
                </Row>
                <Row>
                    <Col>
                    <h3>Table1</h3>
                    </Col>
                    <Col>
                    {
                        <>
                            <Row>
                                <Col>
                                    <TableForm handleSubmit={addTable} revText={revText} labelText = "add table" />
                                </Col>
                            </Row>
                            <Row>
                                <Col>
                                    <hr/>
                                
                                </Col>
                            </Row>
                        </>
                    }
                    {
                        tables?.map((t) => {

                            return(
                                <>
                                    <Row>
                                        <Col>
                                        {t.body}
                                        </Col>
                                    </Row>
                                    <Row>
                                         <Col>
                                            <hr/>                             
                                        </Col>
                                    </Row>
                                </>
                            )
                        })
                    }
                    </Col>
                </Row>
                <Row>
                    <Col>
                        <hr/>                               
                    </Col>
                </Row>
            </Container>

        </div>
    )
}