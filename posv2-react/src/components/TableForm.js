import {Form,Button} from 'react-bootstrap';

const TableForm = ({handleSubmit,revText,labelText,defaultValue}) => {

    return (
        <Form>
            <Form.Group classname="tb-3" controlId ="exampleForm.ControlTestarea1">
                <Form.Label>
                    {labelText}
                </Form.Label>
                <Form.Control ref={refText} as="textarea" rows={3} defaultValue={defaultValue}/>
            </Form.Group>
            <Button variant="outline-info" onClick ={handleSubmit}>Submit</Button>
        </Form>
    )
}