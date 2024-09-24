import './Header.css'

export default function Header({onPageChanged})
{
    return(
        <div id="navigation">
            <img src="images/logo.png" alt="Northwind Logo" />
            <h1>Northwind Traders</h1>

            <div className="link" onClick={() => onPageChanged("employees")}>Employees</div>
        </div>
    )
}