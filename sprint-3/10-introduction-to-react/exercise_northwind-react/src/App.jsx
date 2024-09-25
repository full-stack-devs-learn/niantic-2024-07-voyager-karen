import { useState } from "react";
import Header from "./components/header/Header";
import EmployeesPage from "./components/employees/employees-page/EmployeesPage";

function App() {
  const [pageName, setPageName] = useState("employees");

  const pageChangeHandler = (pageName) => {
    setPageName(pageName);
  };

  return (
    <>
      <Header onPageChanged={pageChangeHandler} />

      {pageName === "employees" && <EmployeesPage />}
    </>
  );
}

export default App;
