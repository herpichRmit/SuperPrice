"use client"

import React from 'react'

import Image from 'next/image'
import HomePage from '../pages/HomePage/HomePage';

import 'bootstrap/dist/css/bootstrap.min.css';

let currentPage, setCurrentPage

export function switchPage (page) {
  setCurrentPage (page)
}

export default function Home() {
  return (<PageSwitcher />)
}

function PageSwitcher () {
  [currentPage, setCurrentPage] = React.useState (<HomePage />)

  return currentPage;

