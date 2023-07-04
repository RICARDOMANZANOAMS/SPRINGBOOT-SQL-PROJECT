import './App.css';
import studentFields from './studentsfields';
import {useState} from 'react';


function App() {

  const [inputs,setInputs]=useState(studentFields);

  const handleClick=()=>{
    const firstName=inputs[0].valueField;
    const lastName=inputs[1].valueField;
    const email=inputs[2].valueField;
    const studentToAPI={firstName,lastName,email};
    console.log(studentToAPI);

    fetch("http://localhost:8080/api/students",{
      method:"POST",
      headers:{'Content-Type':"application/json"},
      body:JSON.stringify(studentToAPI)
    
    })

  }
 
  const handleChange=(id,valueReceivedFromBox)=>{
    const updateFields=inputs.map((studentInput)=>studentInput.idField===id ? {...studentInput,valueField:valueReceivedFromBox}:studentInput);
    setInputs(updateFields);

  };
  return (
    <div className="App">
      <header className="App-header">
       
       <h1>Student Form 2</h1>
       <h1>
        {inputs.map((studentField)=>(
          <ul>
            <li className='listclass'>
              {/* label allows to write the label of the field. htmlfor should match with the id in the input to be align in the presentation */}
              <label htmlFor={studentField.idField}>{studentField.nameField}</label> 
              {/* The input id should match with the htmlfor to be aligned in the same line */}
              <input 
              id={studentField.idField}
              key={studentField.idField}
              type="text"
              value={studentField.valueField}
              onChange={(e)=>handleChange(studentField.idField,e.target.value)}  // e.target.value means that it takes the value typed in the box
              />

            </li>
          </ul>)
        )}
       </h1>
       
       <button className="button" onClick={handleClick}>Submit record</button>
      </header>
    </div>
  );
}

export default App;