import './SearchResult.css'

import PriceCompare from '../PriceCompare/PriceCompare.tsx'

export default function SearchResult ({ product }) {
    return (
        <div className="search-result">
            <div className="name-and-info">
                <div className="product-name">
                    {product.name}
                </div>
                <div className="product-info">
                    <div className="product-brand">
                        {product.brand}
                    </div>
                    <div className="product-size">
                        {product.size}
                    </div>
                </div>
            </div>
            <PriceCompare prices={product.prices} />
        </div>
    )
}

