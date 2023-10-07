import PriceComparison from '../../components/PriceComparison/PriceComparison';
import './SearchResultsPage.css'
import Link from 'next/link';


interface Product {
  id: number;
  title: string;
  store: string;
  brand: string;
  category: string;
  price: number;
  description: string;
}

interface SearchResultsPageProps {
  inputProducts: Product[];
  title: String;
}


// group objects appropriately
function groupObjectsByTitle(products: Product[]): Product[][] {
    const grouped: { [title: string]: Product[] } = {};
  
    // Group objects by their title
    for (const product of products) {
      if (!grouped[product.title]) {
        grouped[product.title] = [];
      }
      grouped[product.title].push(product);
    }
  
    // Convert the grouped object into an array of arrays
    const result: Product[][] = [];
    for (const title in grouped) {
      if (grouped.hasOwnProperty(title)) {
        result.push(grouped[title]);
      }
    }
  
    return result;
  }


function createCards(products: Product[][]) {
    const cardElements = [];

    for (let i = 0; i < products.length; i++) {
        cardElements.push(
                <Link href={'/product/'+ products[i][0].title } className="sr_container-card">
                    <div className="sr_container-card_row">
    
                        <div className="sr_container-card_row-details">
                            <h3>{products[i][0].title}</h3>
    
                            <p>{products[i][0].brand}</p>
                            <p>{products[i][0].description}</p>
                        </div>
    
                        <div className="sr_container-card_row-comparison">
                            <PriceComparison comparisonProducts={products[i]} showAdd={false} />
                        </div>
    
                    </div>
    
                </Link>
            )
      }
    return cardElements;
} 


//<PriceComparison comparisonProducts={inputProducts} />
export default function SearchResultsPage({ inputProducts, title }: SearchResultsPageProps) {
  // Check if inputProducts is an array and contains at least one element
  if (!Array.isArray(inputProducts) || inputProducts.length === 0) {
    // Handle the case where inputProducts is empty or not an array
    return <div>No product data available.</div>;
  }
  const cards = createCards(groupObjectsByTitle(inputProducts))

  return (
    <div className="sr_product-page">
            <div className="sr_header_row">
              <Link href='/' >Back</Link>
              <h1>{title === "" ? "Search results" : title}</h1>
              <div></div>
            </div>

            <div className="sr_container">{cards}</div>
    </div>
  )
}

