import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './Login';
import Admin from './Admin';
import Student from "./student/student";
import StudentView from './views/students/StudentView';
import AsistanView from "./views/asistan/AsistanView";
import LessonView from "./views/lesson/LessonView";
import Asistan from "./asistan/asistan";
import Akademisyen from "./akademisyen/akademisyen";
import ExamView from "./exam/ExamView";
import {toast} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import AkademisyenView from "./views/akademisyen/AkademisyenView";

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Login/>} />
                    <Route path="/Login" element={<Login/>} />
                    <Route path="/Admin" element={<Admin/>} />
                    <Route path ="/Student" element={<Student/>} />
                    <Route path = "/Exam" element = {<ExamView/>} />
                    <Route path ="/Asistan" element={<Asistan/>} />
                    <Route path ="/Akademisyen" element={<Akademisyen/>} />
                    <Route path='/StudentView' element= {<StudentView/>}/>
                    <Route path='/AsistanView' element= {<AsistanView/>}/>
                    <Route path='/AkademisyenView' element= {<AkademisyenView/>}/>
                    <Route path='/LessonView' element= {<LessonView/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;