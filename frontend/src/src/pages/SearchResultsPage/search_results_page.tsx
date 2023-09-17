import NavBar from '../../components/NavBar/NavBar';
import SearchBar from '../../components/SearchBar/SearchBar';
import CategoriesMenu from '../../components/CategoriesMenu/CategoriesMenu';
import Head from '../../components/Head/Head';
import './search_results.css';
export default function SearchResultsPage() {
  return (
    <div className="home-page">
        <NavBar shouldShowSearchBar={false}/>
        <main>
        
                 
        <CategoriesMenu />

  <div class="header">
  <h1>Search Results for:</h1>
</div>
  <div className="sep">
  </div>
  
  <div class="grid-container">
  <div>1</div>
  <div>Price:</div>
  <div>STORE</div>
  
  
</div>
  <div className="sep">
  </div> 
  <div class="grid-container">
  <div>2</div>
  <div>Price:</div>
  <div>STORE</div>
  
</div>
   <div className="sep">
  </div>
  <div class="grid-container">
  <div>3</div>
  <div>Price:</div>
  <div>STORE</div>
  
</div>


        </main>
    </div>

  
  
  
  )
  
}
