"use client"
import NavBar from '../../components/NavBar/NavBar';
import SearchBar from '../../components/SearchBar/SearchBar';
import CategoriesMenu from '../../components/CategoriesMenu/CategoriesMenu';
import Link from 'next/link'
import './HomePage.css'

export default function HomePage() {
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
            
            <CategoriesMenu />
            
        </main>
    </div>
  )
}
