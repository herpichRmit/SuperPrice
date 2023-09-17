"use client"

import './CategoryCard.css'

import { switchPage } from '../../app/page.tsx'
import SearchResultsPage from '../../pages/cSearchResultsPage/SearchResultsPage.tsx'

export default function CategoryCard ({ category }) {
    let click = function (cat) {

        let newPage = <SearchResultsPage products= {cat.products} heading={cat.name} />

        switchPage (newPage)
    }

    return (
        <div className="category-card" onClick={click.bind (this, category)} >
            <img />
            <div className="category-label">
                {category.name}
            </div>
        </div>
    )
}

