import './SearchBar.css';

import Form from 'react-bootstrap/Form';

export default function SearchBar() {
  return (
     <form target="#">
        <div className="search-bar">
            <input className="form-control search-bar" type="text" placeholder="Search groceries and save money" />
        </div>
     </form>
  )
}