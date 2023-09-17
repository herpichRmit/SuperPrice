import './NavBar.css';

import SearchBar from '../SearchBar/SearchBar';

export default function NavBar({shouldShowSearchBar = true}) {
  return (
    <nav className="nav-bar" >
        <img className="logo" src="/logo.png" />
        {shouldShowSearchBar ? <SearchBar /> : ""}
        <div>
            {/* Shopping cart icon */}
        </div>
    </nav>
  )
}

