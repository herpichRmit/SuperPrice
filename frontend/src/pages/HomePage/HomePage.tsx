"use client"
import NavBar from '../../components/NavBar/NavBar';
import SearchBar from '../../components/SearchBar/SearchBar';
import CategoriesMenu from '../../components/CategoriesMenu/CategoriesMenu';
import Link from 'next/link'
import './HomePage.css'

interface PriceProps {
  store : String
  priceCents : number
}

interface ProductProps {
  name: string;
  brand: string;
  size: string;
  prices: PriceProps[];
}


interface CategoryProps {
  name : String,
  products : ProductProps[]
}

interface CategoryCardProps {
  category : CategoryProps
}

interface HomePageProps {
  inputCategories : CategoryProps[]
}

export default function HomePage({ inputCategories }: HomePageProps) {
  return (
    <div className="home-page">
        {/* <NavBar shouldShowSearchBar={false}/> */}
        <main>
            <div className="home-page_hero">
              <div className="home-page_title-and-search">
                <h1>Welcome to SuperPrice</h1>
                <SearchBar />
                <div />
              </div>
            </div>
            
            <CategoriesMenu inputCategories={inputCategories} />
            
        </main>
    </div>
  )
}
