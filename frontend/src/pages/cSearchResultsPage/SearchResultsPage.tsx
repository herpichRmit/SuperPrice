/*
import './SearchResultsPage.css'

import NavBar from '../../components/NavBar/NavBar'
import BackButton from '../../components/BackButton/BackButton'
import SearchResult from '../../components/SearchResult/SearchResult'

export default function SearchResultsPage({
    products,
    heading = "Search Results"
}) {
  return (
    <div className="search-results-page">
        {*//*<NavBar shouldShowSearchBar={true}/>*//*}
        <div className="back-button-and-heading">
            <BackButton />
            <h1 className="search-results-heading">
                {heading}
            </h1>
        </div>
        <main>
            {products.map (
                product => <SearchResult product={product} key={product} />
            )}
        </main>
    </div>
  )
}

*/